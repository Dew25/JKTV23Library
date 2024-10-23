package ee.ivkhkdev;


import static org.junit.jupiter.api.Assertions.assertTrue;


class AppTest {

//    Input inputMock;
//    Repository repositoryMock;
//    PrintStream defaultOut;
//    ByteArrayOutputStream mockOut;
//    @BeforeEach
//    void setUp() {
//        inputMock = Mockito.mock(ConsoleInput.class);
//        repositoryMock = Mockito.mock(Storage.class);
//        defaultOut = System.out;
//        mockOut = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(mockOut));
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.setOut(defaultOut);
//    }
//
//    @Test
//    void runExit() {
//        when(inputMock.nextLine()).thenReturn("0");
//        App app = new App();
//        app.run();
//        String expected = "До свидания!";
//        String actual = mockOut.toString();
////        System.setOut(defaultOut);
////        System.out.println(actual);
//        assertTrue(actual.contains(expected));
//    }
//   @Test
//    void runAddBook(){
//        AppHelperBook appHelperBookInputMock = mock(AppHelperBook.class);
//        Book bookMock = Mockito.mock(Book.class);
//        when(appHelperBookInputMock.createBook()).thenReturn(bookMock);
//        Repository<Book> repositoryMock = Mockito.mock(Storage.class);
//        BookService bookService = new BookService();
//        boolean result = bookService.addBook();
//        verify(repositoryMock, times(1)).save(bookMock);
//        assertTrue(result);
//    }
//    //@Test
//    void runAddUser(){
//        User userMock = Mockito.mock(User.class);
//        AppHelperUser appHelperUserInputMock = Mockito.mock(AppHelperUser.class);
//        Repository<User> repositoryMock = mock(Storage.class);
//        when(appHelperUserInputMock.createUser(inputMock)).thenReturn(userMock);
//        UserService userService = new UserService(inputMock, repositoryMock);
//        boolean result = userService.addUser(appHelperUserInputMock);
//        verify(repositoryMock, times(1)).save(userMock);
//        assertTrue(result);
//    }
}