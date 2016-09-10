This is a sample App made for a Technical Test.

Mainly, the App loads at the begginning a base URL in a WebView contained in the main Activity. It also fetches data from a server, that is parsed and showed in a NavigationDrawer to navigate through different Web categories.
Due to time reasons, the data parsing is not working at all, it doesn't get all the nested childs for each category.

The App has made following the Model View Presenter (MVP) pattern:

- Model: get data from the server and send it to the Presenter. It is done with the Retrofit 2 library, using an asynchronous task that notifies the Presenter when all the data is fetched through a Handler. The modelling schema has been done passing the content of the server response to http://www.jsonschema2pojo.org/ but, as it's already said, it's not correct and should be checked more in deep.
- View: only shows the data the Presenter sends to it, and get all the user interaction events and send them to the Presenter.
- Presenter: the clever layer. Gets all the events and requests sent by the View, requests data to the Model layer, get and transform all this data and send to the View what it has to show.

One unit test about the WebView load URL, and one UI test about opening the NavigationDrawer has been developed, in order to show how I usually implement them. There should be more tests implemented, as times and places the connection status of the device should be checked before interacting with network (made with the ConnectionManager class). Again, due to the time I've only included a little sample about tests and chacks.

Related to the NavigationDrawer navigation stack, the idea was to maintain always the last state when a link was clicked and the Drawer closed. For example, if a link is opened in a 3rd child deep, the next time the NavigationDrawer would be opened it would be still showing that hierarchical position.
