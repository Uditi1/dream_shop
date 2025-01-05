package com.dailycode.dreamshops.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dailycode.dreamshops.dto.ImageDto;
import com.dailycode.dreamshops.model.Image;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(List<MultipartFile> file, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
