LIBRARY MANAGEMENT SYSTEM (Java 17+)

HOW TO RUN IN VS CODE
1. Extract this folder.
2. Open the LibraryManagementSystem folder in VS Code.
3. Make sure a JDK is installed and the Microsoft Extension Pack for Java is installed.
4. Open Main.java and click Run, or use the terminal:
   javac *.java
   java Main
5. Use menu option 0 to save and exit. Data is stored in the data folder.

FEATURES
- Book and DVD subclasses of abstract LibraryItem
- Borrowable interface
- Member maximum of three active loans
- Custom exceptions for unavailable items and member loan limit
- Maps keyed by item/member IDs
- CSV save/load for items, members, and active loans
- Overdue loan listing and title search using streams

LOAN PERIODS
- Book: 21 days
- DVD: 7 days

NOTES
- This is a learning project. CSV data is intended for one local program instance.
- Only active loans are persisted; returned-loan history is not maintained.
