package com.team.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class ProductDTO {
    private Integer productNo;
    private String productName;
    private String productCategory;
    private Integer productAmount;
    private String productPurchaseDate;
    private String productSupplier;
    private Integer productPrice;
    private String productImage;
    private String productDescription;
    private Boolean productState;
}
