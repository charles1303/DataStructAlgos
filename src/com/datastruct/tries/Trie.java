package com.datastruct.tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private class TrieNode{
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode(){
			this.children = new HashMap<>();
			this.endOfWord = false;
		}
	}
	
	private final TrieNode root;
	
	public Trie(){
		this.root = new TrieNode();
	}
	
	public void insert(String word){
		TrieNode current = this.root;
		for(int i = 0; i < word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null){
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}
	
	public void insertRecursive(String word){
		insertRecursive(this.root,word,0);
	}

	private void insertRecursive(TrieNode current, String word, int index) {
		if(index == word.length()){
			current.endOfWord = true;
			return;
		}
		char ch =  word.charAt(index);
		TrieNode node = current.children.get(ch);
		
		if(node == null){
			node = new TrieNode();
			current.children.put(ch, node);
		}
		insertRecursive(node, word, index + 1);
		
	}
	
	public boolean search(String word){
		TrieNode current = this.root;
		for(int i = 0; i < word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null)
				return false;
			current = node;
		}
		return current.endOfWord;
	}
	public boolean searchRecursive(String word){
		return searchRecursive(this.root,word,0);
	}

	private boolean searchRecursive(TrieNode current, String word, int index) {
		if(index == word.length())
			return current.endOfWord;
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node == null)
			return false;
		return searchRecursive(node,word,index+1);
	}
	
	public void delete(String word){
		TrieNode current = this.root;
		for(int i = 0; i < word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node != null)
				continue;
		}
	}
	
	public void deleteRecursive(String word){
		deleteRecursive(this.root, word, 0);
	}

	private boolean deleteRecursive(TrieNode current, String word, int index) {
		if(index == word.length()){
			if(!current.endOfWord)
				return false;
			current.endOfWord = false;
			return current.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node == null)
			return false;
		
		boolean shouldDeleteCurrentNode = deleteRecursive(node, word, index + 1);
		
		if(shouldDeleteCurrentNode){
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}

}
