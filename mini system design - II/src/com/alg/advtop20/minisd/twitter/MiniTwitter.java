package com.alg.advtop20.minisd.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Tweet {
	private String text;
	private int ts;

	public Tweet(String text, int ts) {
		super();
		this.text = text;
		this.ts = ts;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTs() {
		return ts;
	}

	public void setTs(int ts) {
		this.ts = ts;
	}

	@Override
	public String toString() {
		return "Tweet [text=" + text + ", ts=" + ts + "]";
	}

}

class MyComparator implements Comparator<Tweet> {

	@Override
	public int compare(Tweet o1, Tweet o2) {
		return o2.getTs() - o1.getTs();
	}

}

public class MiniTwitter {
	private HashMap<String, LinkedList<Tweet>> tweets;
	private HashMap<String, HashSet<String>> followers;
	private HashMap<String, HashSet<String>> followees;

	public MiniTwitter() {
		tweets = new HashMap<String, LinkedList<Tweet>>();
		followers = new HashMap<String, HashSet<String>>();
		followees = new HashMap<String, HashSet<String>>();
	}

	public void postTweet(String user_id, String tweet_text, int ts) {
		LinkedList<Tweet> user_tweets = tweets.get(user_id);
		if (user_tweets == null) {
			user_tweets = new LinkedList<Tweet>();
			tweets.put(user_id, user_tweets);
		}
		user_tweets.add(new Tweet(tweet_text, ts));

	}

	public void follow(String follower_id, String followee_id) {
		HashSet<String> user_followers = followers.get(followee_id);
		if (user_followers == null) {
			user_followers = new HashSet<String>();
			followers.put(followee_id, user_followers);
		}
		user_followers.add(follower_id);

		HashSet<String> user_followees = followees.get(follower_id);
		if (user_followees == null) {
			user_followees = new HashSet<String>();
			followees.put(follower_id, user_followees);
		}
		user_followees.add(followee_id);
	}

	public void unfollow(String follower_id, String followee_id) {
		HashSet<String> user_followers = followers.get(followee_id);
		if (user_followers != null)
			user_followers.remove(follower_id);

		HashSet<String> user_followees = followees.get(follower_id);
		if (user_followees != null)
			user_followees.remove(followee_id);

	}

	public List<Tweet> timeline(String user_id) {
		LinkedList<Tweet> user_tweets = tweets.get(user_id);
		if (user_tweets == null)
			return null;

		List<Tweet> res = new LinkedList<Tweet>();
		int ntweets = Math.min(user_tweets.size(), 10);
		for (int i = 0; i < ntweets; ++i) {
			res.add(user_tweets.get(user_tweets.size() - 1 - i));
		}
		return res;
	}

	public List<Tweet> newsfeed(String user_id) {
		// collect the feed of given user
		List<Tweet> feed = timeline(user_id);
		if (feed == null)
			feed = new LinkedList<Tweet>();

		// collect the feed of all the followees
		//Bug: Check for null for timeline call inside loop
		HashSet<String> user_followees = followees.get(user_id);
		for (String followee : user_followees)
			feed.addAll(timeline(followee));

		Collections.sort(feed, new MyComparator());

		// collect top-10 tweets
		List<Tweet> res = new LinkedList<Tweet>();
		int ntweets = Math.min(feed.size(), 10);
		for (int i = 0; i < ntweets; ++i) {
			res.add(feed.get(i));
		}
		return res;

	}

	public static void main(String[] args) {
		MiniTwitter twitter = new MiniTwitter();
		int nusers = 5;
		Random r = new Random();
		for (int ts = 1; ts <= 100; ++ts) {
			int rid = r.nextInt(nusers);
			twitter.postTweet("user" + rid, "tweet" + rid + "_" + ts, ts);
		}
		for (int i = 0; i < nusers; ++i)
			System.out.println("user" + i + ":" + twitter.timeline("user" + i));

		twitter.follow("user0", "user1");
		twitter.follow("user2", "user1");
		twitter.follow("user0", "user2");

		System.out.println(twitter.newsfeed("user0"));

	}

}
