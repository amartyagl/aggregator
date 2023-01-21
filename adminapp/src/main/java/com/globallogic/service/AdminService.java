package com.globallogic.service;

import com.globallogic.exception.PostNotExist;
import com.globallogic.feign.GloQuroPostProxy;
import com.globallogic.feign.UserProxy;
import com.globallogic.modal.GloQuoraPost;
import com.globallogic.modal.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class AdminService {

    @Autowired
    GloQuroPostProxy gloQuroPostProxy;
    @Autowired
    UserProxy userProxy;

   public List<GloQuoraPost> getPostByUserId(int userId) throws PostNotExist {
        List<GloQuoraPost> allPost=gloQuroPostProxy.getAllPost();
        List<GloQuoraPost> postOfUser=new ArrayList<>();
        Iterator<GloQuoraPost> postIterator=allPost.listIterator();
        while (postIterator.hasNext())
        {
            GloQuoraPost quoraPost=postIterator.next();
            if(quoraPost.getUserid()==userId)
            {
                postOfUser.add(quoraPost);
            }
        }
        if (!postOfUser.isEmpty())
        {
            log.info("returning all the post for given user");
            return  postOfUser;
        }
        else
        {
            throw new PostNotExist("There is 0 post for this user id");
        }

    }

    public List<User> allUserWithPost() throws PostNotExist {
        List<User> allUsers=userProxy.getAllUser();
        Iterator<User> userIterator=allUsers.listIterator();
        while (userIterator.hasNext())
        {
            User user=userIterator.next();
            user.setGloQuoraPosts(getPostByUserId(user.getUserId()));
            log.info("returning all the post for given user with user details");
        }
        return allUsers;
    }

    public List<String> getAllNamesWithPostMoreThanK(int k) throws PostNotExist {
        List<User> allUsers=allUserWithPost();
        List<String> usernames=new ArrayList<>();
        Iterator<User> userIterator=allUsers.listIterator();
        while (userIterator.hasNext())
        {
            User user=userIterator.next();
            if(user.getGloQuoraPosts().size()>k)
            {
                usernames.add(user.getName());
                log.info("returning all the name for given user with post more than k");
            }
        }
        return usernames;
    }
    public List<String> getAllCompanyName() throws PostNotExist {
        List<User> allUsers=allUserWithPost();
        List<String> company=new ArrayList<>();
        Iterator<User> userIterator=allUsers.listIterator();
        while (userIterator.hasNext())
        {
            User user=userIterator.next();
            if(user.getGloQuoraPosts().size()>0)
            {
                company.add(user.getCompany().getName());
                log.info("returning all the company for post count greater than 0");
            }
        }
        return company;
    }
}
