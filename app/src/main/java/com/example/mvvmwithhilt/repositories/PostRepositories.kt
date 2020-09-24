package com.example.mvvmwithhilt.repositories

import com.example.mvvmwithhilt.model.CourseModel
import com.example.mvvmwithhilt.model.PostModel
import kotlinx.coroutines.delay
import java.util.logging.Handler

class PostRepositories{
    suspend fun getPosts(): MutableList<PostModel> {
        val list: MutableList<PostModel> = ArrayList()
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        list.add(PostModel(author = "Ariful Jannat Arif",comment = 300,content = "this is the post content",downVote = 100,upVotes = 30,images = mutableListOf(),title = "new announcement",eventTime = "1 hour ago"))
        delay(2000)
        return list
    }

    suspend fun getCourses(): List<CourseModel> {
        val list: MutableList<CourseModel> = ArrayList()
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("EEE-1111, Artificial Intelligence","Ariful Jannat","summer 17"))
        list.add(CourseModel("Last Item","Ariful Jannat","summer 17"))

        delay(2500)
        return list
    }
}