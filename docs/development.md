******# Development

#### | [Overview](../README.md) | Development |

## Structure

### Main

`src/main/java/Main.java`

Main is the starting point of the application. It instantiates the base of the application.

### Base

`pages.Base`

This is the base upon which all application pages sit. It includes a JFrame (the main application window)
and a CardLayout (used for switching pages.)

### Pages

`pages.*`

Pages are the bulk of the application. Everything the user can see and do is on a page. 
Each page is its own class with GUI and functionality defined within. Pages are extended CPages, which are extended JPanels.

`pages.Header`

The header is used for basic navigation. Most pages will include the header at the top.

### GUI

`gui.*`

These are extended and customized versions of regular Swing components.

`gui.General`

This is a central hub for GUI elements. Colors, fonts, and resizing functions are defined here.

### Database

`model.*`

A model represents a table in the database. Pages can use them to easily retrieve and interact with data.
Models speak to the database manager.

`db.DBManager`

The database manager speaks directly to the database. It acts as an intermediary between the models and the database.******