SELECT
    MONTH(HISTORY.START_DATE) AS MONTH,
    HISTORY.CAR_ID,
    COUNT(*) AS RECORDS
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY AS HISTORY
INNER JOIN
(
    SELECT
        CAR_ID,
        COUNT(*) AS CNT
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE
        YEAR(START_DATE) = 2022
    AND
        MONTH(START_DATE) >= 8
    AND
        MONTH(START_DATE) <= 10
    GROUP BY
        CAR_ID
) SUB_HISTORY
ON
    HISTORY.CAR_ID = SUB_HISTORY.CAR_ID
WHERE
    SUB_HISTORY.CNT >= 5
AND
    YEAR(HISTORY.START_DATE) = 2022
AND
    MONTH(HISTORY.START_DATE) >= 8
AND
    MONTH(HISTORY.START_DATE) <= 10
GROUP BY
    HISTORY.CAR_ID,
    MONTH(HISTORY.START_DATE)
ORDER BY
    MONTH(HISTORY.START_DATE) ASC,
    HISTORY.CAR_ID DESC;