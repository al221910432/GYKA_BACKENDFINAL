package com.example.oxxo.service;

import java.util.List;

import com.example.oxxo.entity.Tag;
import com.example.oxxo.model.request.CreateTagRequest;

public interface TagService {
    
    List<Tag> getListTag();
    List<Tag> getListEnabled();
    Tag createTag(CreateTagRequest request);

    Tag updateTag(long id,CreateTagRequest request);

    void enableTag(long id);

    void deleleTag(long id);

}
