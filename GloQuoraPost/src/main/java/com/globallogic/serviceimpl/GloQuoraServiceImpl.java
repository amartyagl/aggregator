package com.globallogic.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.exception.PostNotExist;
import com.globallogic.modal.GloQuoraPost;
import com.globallogic.repository.GloQuoraRepository;
import com.globallogic.service.GloQuoraService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class GloQuoraServiceImpl implements GloQuoraService{
	
	@Autowired
	GloQuoraRepository gloQuoraRepository;

	@Override
	public GloQuoraPost addPost(GloQuoraPost post) {
		log.info("adding new post");
		return gloQuoraRepository.save(post);
	}

	@Override
	public GloQuoraPost updatePost(GloQuoraPost post) throws PostNotExist {
		Optional<GloQuoraPost> optPost=gloQuoraRepository.findById(post.getPostid());
        if(optPost.isPresent())
        {
            GloQuoraPost updatedPost=optPost.get();
            updatedPost.setBody(post.getBody());
            updatedPost.setPostid(post.getPostid());
            updatedPost.setTitle(post.getTitle());
            log.info(" post is updated");
            return gloQuoraRepository.save(updatedPost);
        }
        else
        {
            log.error("unable to update post as post not exist");
            throw new PostNotExist("Post not exist to update");
        }
	}

	@Override
	public List<GloQuoraPost> getAllPost() {
		return gloQuoraRepository.findAll();
	}

	@Override
	public void deletePost(String postId) throws PostNotExist {
		Optional<GloQuoraPost> optPost=gloQuoraRepository.findById(postId);
        if(optPost.isPresent())
        {
            gloQuoraRepository.deleteById(postId);
            log.info("post deleted successfully");
        }
        else
        {
            throw new PostNotExist("post not exist to be deleted");
        }
		
	}


}
