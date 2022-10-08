package com.chrisxyq.vxmsgpush.dto;

import lombok.Data;

/**
 * 获取Access token
 * 返回
 */
@Data
public class TokenInfo {
    /**
     * 	获取到的凭证
     */
    private String access_token;
    /**
     * 凭证有效时间，单位：秒
     */
    private String expires_in;

}
