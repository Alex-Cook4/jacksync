package com.shagaba.jacksync.merge;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.shagaba.jacksync.exception.MergeProcessingException;
import com.shagaba.jacksync.operation.MergeOperation;

public interface MergeProcessor {
	/**
	 * 
	 * @param sourceObject
	 * @param jsonValue
	 * @return
	 * @throws MergeProcessingException 
	 */
	public <T> T merge(T sourceObject, String jsonValue) throws MergeProcessingException;

	/**
	 * 
	 * @param sourceObject
	 * @param path
	 * @param jsonValue
	 * @return
	 * @throws MergeProcessingException 
	 */
	public <T> T merge(T sourceObject, String path, String jsonValue) throws MergeProcessingException;

	/**
	 * 
	 * @param sourceObject
	 * @param value
	 * @return
	 * @throws MergeProcessingException 
	 */
	public <T> T merge(T sourceObject, JsonNode value) throws MergeProcessingException;

	/**
	 * 
	 * @param sourceObject
	 * @param path
	 * @param value
	 * @return
	 * @throws MergeProcessingException 
	 */
	public <T> T merge(T sourceObject, JsonPointer path, JsonNode value) throws MergeProcessingException;

	/**
	 * 
	 * @param sourceObject
	 * @param operation
	 * @return
	 * @throws MergeProcessingException 
	 */
	public <T> T merge(T sourceObject, MergeOperation operation) throws MergeProcessingException;

}
