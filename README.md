# Android Project 5 - *BitFit Part 1*

Submitted by: **Adam Ramsey**

**BitFit Part 1** is a health metrics app that allows users to track sleep. 

Time spent: **10** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **At least one health metric is tracked (based on user input)**
  - Chosen metric(s): Sleep
- [x] **There is a "create entry" UI that prompts users to make their daily entry**
- [x] **New entries are saved in a database and then updated in the RecyclerView**
- [x] **On application restart, previously entered entries are preserved (i.e., are *persistent*)**
 
The following **optional** features are implemented:

- [x] **Create a UI for tracking averages and trends in metrics**
- [x] **Improve and customize the user interface through styling and coloring**
- [x] **Implement orientation responsivity**
- [ ] **Add a daily photo feature**

The following **additional** features are implemented:

- [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='bitfit1.gif' title='Video Walkthrough: Portrait' width='' alt='Video Walkthrough: Portrait' />
<img src='bitfit2.gif' title='Video Walkthrough: Landscape' width='' alt='Video Walkthrough: Landscape' />

GIF created with [ScreenToGif](https://www.screentogif.com/) for Windows


## Notes

- Getting averages to work was tricky, a lot of finnicky implementation for a "live" update (by pressing the "add" button).
- Could not get "hours" to show next to the hours slept. Doing `hours = "Hours Slept: $hoursSlept` just didn't work and it was a bit frustrating so I didn't bother.
- Horizontal view was something I couldn't figure out how to implement nicely so it's pretty much just the portrait view.
- Did not know exactly what it meant by "daily photo feature" so I did not implement.

## License

    Copyright [2023] [Adam Ramsey]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.