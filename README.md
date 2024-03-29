# Local Tastes
## Local Tastes is our CS 4540 Final Project! Local Tastes can be thought of as an Instagram-like food recipe sharing app.

## Functionalities: 

- Users register before accessing app, users then must login.
- Users may view a 'feed' that they can browse and view local favorite recipes.
- Users may add their very own recipe to the feed so that others users may view.
- Users may view a YouTube video to aid in creation of recipe.

## Technical Implementations:
- Local Tastes uses a RecyclerView as the 'feed' which holds all recipes. This keeps the user experience smooth as 'cards' that are not visible to the user are then reassigned to incoming 'cards'. Our RecyclerView also makes use of 'Item Decorations' within the RecyclerView, which gives our cards a custom look and feel.
- Information is stored in a Firebase Livedata Database to write and retrieve information.
- Users first login using either their own personal email or using GMail Login.
- User Authentication is stored and accesed through Firebase Authentication which allows users to create an account and access it.
- Each recipe includes a YouTube link to a video instruction using the YouTube Android Player API.




## Video Demo:
### https://youtu.be/apg_r-bnkXI
## Screenshots:
### Welcome Screen Before User Login
![Before Login](https://user-images.githubusercontent.com/31228341/70765564-03e14a80-1d10-11ea-93d6-5e0fdc26b7b7.png)

### During Login Screen
![During Login Screen](https://user-images.githubusercontent.com/31228341/70765607-19ef0b00-1d10-11ea-858c-e9bc318b454d.png)

### User Logged In 
![User Logged in](https://user-images.githubusercontent.com/31228341/70765627-270bfa00-1d10-11ea-9846-4829ee73dbb5.png)

### Find Recipe Screen
![Find Recipe Screenshot](https://user-images.githubusercontent.com/31228341/70765650-3723d980-1d10-11ea-99cb-f1807c11b01b.png)

### User Add a Recipe Screen
![User Add a Recipe](https://user-images.githubusercontent.com/31228341/70818594-f61bdb80-1d88-11ea-8e36-55f69aba5583.png)
