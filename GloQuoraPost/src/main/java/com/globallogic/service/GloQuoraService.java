package com.globallogic.service;

import java.util.List;

import com.globallogic.exception.PostNotExist;
import com.globallogic.modal.GloQuoraPost;

public interface GloQuoraService {

	GloQuoraPost addPost(GloQuoraPost post);
    GloQuoraPost updatePost(GloQuoraPost post) throws PostNotExist;
    List<GloQuoraPost> getAllPost();
    void deletePost(String postId) throws PostNotExist;
}
