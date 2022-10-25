package com.stussy.stussclone20220929junho.dto.shop;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CollectionListRespDto {
    private int groupId;
    private String category;
    private String name;
    private int price;
    private String imgName;
    private int totalCount;
}
