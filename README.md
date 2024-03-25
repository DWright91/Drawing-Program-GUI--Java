# Drawing-Program/GUI - Java

Purpose: Create and design a drawing program simmiliar to paint, utilizing a GUI (Graphical User Iterface).

Operations: draw line, draw triangle, draw polygon, select/unselect one-to-many objects at a time, delete one-to-many objects at a time, insert label, save, open, undo/redo, move.

Drawing a Triangle: 
  • The triangle is specified by clicking on three points. The system responds
    as follows: Button click changes cursor. Shows a point after one click; after 2 clicks, shows a line
    between two clicked points; after 3 clicks, shows triangle and cursor returns to default. Undo/Redo
    should remove/restore entire triangle.

Drawing a polygon:
  • Button click changes cursor. After one left click, show point; after 2 left clicks show line; add a line
    after each left click. If right button is clicked, a line is added between first left click and the last
    left click and cursor returns to default. Undo/Redo should remove/restore entire polygon.

Moving an item:
   • Some item(or items) have to be selected when move is invoked; otherwise move has no effect. When
    the move button is clicked, cursor changes. Mouse has to be clicked, dragged some distance, and
    released; all the selected items will be translated by that distance. Note that if mouse is clicked
    at (x1, y1) and released at (x2, y2) all the selected items must be translated by (x2-x1),
    (y2-y1). This will require that all items have a translate() method; see how the Delete operation
    is implemented for a similar example. Undo/Redo should reverse/repeat the translation.


----------------------------------------------------------------------------------------
Drawing Panel: 

![image](https://github.com/DWright91/Drawing-Program-GUI--Java/assets/94549091/09cec3fd-0f70-4339-a973-6140586c11fa)
