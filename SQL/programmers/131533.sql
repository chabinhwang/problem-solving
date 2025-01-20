SELECT PRODUCT_CODE, (sales.sales_sum*product.price) AS SALES
FROM PRODUCT AS product
JOIN (
    SELECT product_id, SUM(sales_amount) AS sales_sum
    FROM OFFLINE_SALE
    GROUP BY product_id
) AS sales
ON product.PRODUCT_ID=sales.product_id
ORDER BY SALES DESC, PRODUCT_CODE ASC