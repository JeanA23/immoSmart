package com.jeananani.immosmart.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.io.Resource;

@Data
@AllArgsConstructor
public class DownloadFileInfo {

    private Resource resource;
    //private Picture picture;
}
