# Development

#### | [Overview](../README.md) | Development |

## Structure

Everything begins at the starting point of the project, the Main file`src/main/java/Main.java`.

From there, we initialize the user interface, starting with the pages of the application.
All pages are instantiaed in the Base class. The Base class creates the initial JFrame (the main application window),
and a CardLayout to switch between each page.

Each page in this application is an instance of CPage (an extended JPanel). Each page is just a sequence
of various UI elements, as well as some extra functions where needed. Pages usually include the Header at the top.
Page content is placed inside of loadContent(), which loads when the page is opened.
Pages are reset() when opened and closed.

(Important note: not every class inside of "pages" is an actual page, some exceptions being the Header and Base.
This should probably be changed to minimize confusion.)

GUI elements can include basic Swing classes or extended versions (for customization).
Customized ones are labeled with a C instead of a J. The gui.General class is useful for standardized things like
color, font, and resizing.

Finally, the database. Basically, the models speak to the database manager, the manager speaks to the database.
Pages can simply access the model to read and write data. Nice and easy. Just make sure any new models line up
nicely with the database.

And that's it for structure. Create CPages, instantiate them in Base, navigate to them in Home,
include customizable GUI elements, and speak to the database through models.