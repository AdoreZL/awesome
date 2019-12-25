package com.zl.awesome.feignclient.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by liqiang on 2018/12/12.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "图片属性数据对象")
public class ImageInfo {
    @ApiModelProperty(value = "图片名称")
    private String imageName;

    @ApiModelProperty(value = "图片流(BASE64串)")
    private String imageStream;

    @ApiModelProperty(value = "图片路径")
    private String imageUrl;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "资源（摄像机等）ID")
    private String  resourceId;

    @ApiModelProperty(value = "服务器创建时间")
    private String serverCreateTime ;

}
