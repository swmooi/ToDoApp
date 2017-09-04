# ToDoApp
A demo Android app to save to-do list.

# Pre-work - ToDoApp

ToDoApp is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: SW Mooi

Time spent: 3 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://imgur.com/OXMFYTt.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** It is great! It is similar to the platform I have used.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** An adapter which implements the Adapter interface, is important because it acts as a bridge between a data set and an adapter view, an object of a class that extends the abstract AdapterView class. 

The function of an adapter is to retrieve data from the data set and to generate View objects based on that data. The generated View objects are then used to populate the adapter view that is bound to the adapter.

ConvertView is a parameter of the getView method. It is used to improve the performance of the Adapter. The Adapter uses the convertView as a way to recycle old View objects. View objects that are not visible are reused instead of having to instantiate an entirely new object each time a new list item is displayed.


## License

    Copyright 2017 SW Mooi.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
