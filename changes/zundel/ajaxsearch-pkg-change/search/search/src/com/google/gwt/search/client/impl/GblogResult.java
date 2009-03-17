/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.search.client.impl;

import com.google.gwt.search.client.BlogResult;
import com.google.gwt.search.jsio.client.BeanProperties;
import com.google.gwt.core.client.GWT;

/**
 * @see http://code.google.com/apis/ajaxsearch/documentation/reference.html#_class_GblogResult
 */
@BeanProperties
public interface GblogResult extends GResult {
  GblogResult IMPL = GWT.create(GblogResult.class);

  String getAuthor(BlogResult obj);

  String getBlogUrl(BlogResult obj);

  String getContent(BlogResult obj);

  String getPostUrl(BlogResult obj);

  String getPublishedDate(BlogResult obj);

  String getTitle(BlogResult obj);

  String getTitleNoFormatting(BlogResult obj);
}