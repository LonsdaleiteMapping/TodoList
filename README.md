Creating a todo list

- Create a Todo list program that the user will be able to use to keep track of what they need to get done. 
- This application will server many purposes:
    - It can be used on its own as a standalone application 
    ----------- Get to the below later ---------------------
    - It can be used inside another application for special purposes

- Task
    - Holds info regarding the action needed to be taken
    - Interface
    - Task methods are
        - showTaskDescription() returns String
        - toString() basically returns the same information of showTaskDescription
        - getTaskOriginator() returns the class that created this task and placed it in the items

- Item 
    - Item are what the todo list handles
    - Interface
    - Item methods are
        - getTask() returns Task
        - getIsDone() returns boolean
        - setIsDone(bool status) void that sets the state of the item 

- Todo List 
    - Handles a list of Items 
    - Singleton (Will explain later)
    - Is able to show list of unfinished Items
    - Is able to show list of finished items


