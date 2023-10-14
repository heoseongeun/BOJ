SELECT p.product_id,
    product_name,
    SUM(price * amount) total_sales
FROM food_product p
JOIN food_order o
    ON p.product_id = o.product_id
WHERE DATE_FORMAT(produce_date, "%Y-%m") = "2022-05"
GROUP BY product_id
ORDER BY total_sales DESC, product_id;