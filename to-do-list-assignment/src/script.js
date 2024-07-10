function addTask () {
    var input = document.getElementById("input");
    // get current text from input field
    var newTask = input.value;
    // only add new item to list if some text was entered 
    if (newTask != "") {
        // create new HTML list item
        var item = document.createElement("li");
        // add HTML for buttons and new task text
        item.innerHTML = '<input type="button" class="done" onclick="markDone(this.parentNode)"  value="&#x2713;" /> ' + '<input type="button" class="remove" onclick="remove(this.parentNode)" value="&#x2715;" /> '+'<input type="button" class="important" onclick="important(this.parentNode)" value="!" />' + newTask;

        // add new item as part of existing list
        document.getElementById("tasks").appendChild(item); 

        /* blank the input value and placeholder */ 
      input.value = "";
      input.placeholder = "enter task..."
    }
}

// change styling used for given item
function markDone (item) {
    item.className = 'finished';
}

/* remove the task if finished */
function remove (item) {
    // remove item completely from document
  if(item.className == 'finished')
    {
      item.remove();
    }
  else{
    alert('You have not finished it');
  }
}

// highlight item from document
function important (item) {
  item.className = "important";
}

/* show author name */
function doAbout() {
  var dAbout = document.getElementById("divabout");
  dAbout.innerHTML = "Author is Himanshu Gupta";
  dAbout.className = "yellowbackground";
}

/* clear the author details */
function clearAbout() {
   var dAbout = document.getElementById("divabout");
  dAbout.innerHTML = "";
}