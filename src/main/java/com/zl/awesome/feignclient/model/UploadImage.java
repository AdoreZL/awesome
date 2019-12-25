package com.zl.awesome.feignclient.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "文件上传到图片服务参数对象")
public class UploadImage {

    @ApiModelProperty(value = "图片byte数据")
    private  byte[] imageData;

    @ApiModelProperty(value = "图片路径")
    private  String imagePath;
}
