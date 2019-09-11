USE MiniShop
CREATE TABLE Category
(CategoryId    int,
 CategoryName  NVARCHAR(128),
 ParentId      int,
 PRIMARY KEY (CategoryId)
 )
CREATE TABLE Author
(AuthorId     int,
 AuthorName   nvarchar(128),
 PRIMARY KEY (AuthorId)
 )
 CREATE TABLE Member
 (MemberId    bigint,
  Username    nvarchar(128),
  Password    nvarchar(128),
  Email       nvarchar(128),
  Fullname    nvarchar(128),
  Gender      tinyint,
  AddedDate   datetime,
  ModifiedDate datetime,
  PRIMARY KEY (MemberId)
  )
CREATE TABLE Publisher
 (PublisherId    int,
  PublisherName  nvarchar(128),
  PRIMARY KEY (PublisherId)
  )
CREATE TABLE Product
(ProductId     int,
 CategoryId    int,
 PublisherId   int,
 AuthorId      int,
 ISBN          nvarchar(16),
 Title         nvarchar(128),
 Pages         smallint,
 Year          smallint,
 Weight        nvarchar(16),
 Size          nvarchar(16),
 Descreption   nvarchar(1024),
 Content       nvarchar(2048),
 ImageUrl      nvarchar(128),
 Price         int,
 PRIMARY KEY (ProductId),
 FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId),
 FOREIGN KEY (AuthorId) REFERENCES Author(AuthorId),
 FOREIGN KEY (PublisherId) REFERENCES Publisher(PublisherId)
 )
CREATE TABLE Status
(StatusId      tinyint,
 StatusName    nvarchar(32),
 PRIMARY KEY (StatusId)
 )
CREATE TABLE Invoice
(InvoiceId       nvarchar(128),
 MemberId        bigint,
 Email           nvarchar(128),
 Tel             nvarchar(16),
 Address         nvarchar(128),
 StatusId        tinyint,
 AddedDate       datetime,
 PRIMARY KEY (InvoiceId),
 FOREIGN KEY (MemberId) REFERENCES Member(MemberId),
 FOREIGN KEY (StatusId) REFERENCES Status(StatusId)
 )
CREATE TABLE InvoiceDetail
(InvoiceId       nvarchar(128),
 ProductId       int,
 Quantify        smallint,
 Price           int,
 FOREIGN KEY (InvoiceId) REFERENCES Invoice(InvoiceId),
 FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
 )
CREATE TABLE Role
(RoleId     int,
 RoleName   nvarchar(128),
 PRIMARY KEY (RoleId)
 )
CREATE TABLE MemberInRole
(RoleId     int,
 MemberId   bigint,
 PRIMARY KEY (RoleId, MemberId),
 FOREIGN KEY (RoleId) REFERENCES Role(RoleId),
 FOREIGN KEY (MemberId) REFERENCES Member(MemberId)
 )


USE MiniShop
INSERT INTO Category VALUES
(1, 'Web Development', NULL),
(2, 'Programming', NULL),
(3, 'Databases', NULL),
(4, 'ASP.NET2', 1),
(5, 'PHP', 1),
(6, 'HTML, CSS', 1),
(7, 'Javascript', 1),
(8, 'C#', 2),
(9, 'Java', 2),
(10, 'C & C++', 2),
(11, 'Python', 2),
(12, 'Mysql', 3),
(13, 'SQL Server', 3),
(14, 'MongoDB', 3),
(15, 'Oracle', 3),
(16, 'Postgree SQL', 3),
(17, 'Stationery', NULL),
(18, 'Student tools', 17);
INSERT INTO Author VALUES
(1, 'Vaskaran Sarcar'),
(2, 'Andrew Troelsen'),
(3, 'Rogers Cadenhead'),
(4, 'Johan Vos'),
(5, 'Michael R. Brzustowicz PhD'),
(6, 'Sayan Mukhopadhyay'),
(7, 'Barry A. Burd'),
(8, 'Clare Churcher'),
(9, 'Michael Coles, Rodney Landrum'),
(10, 'Adam Jorgensen, Brian Knight, Ross LoForte, Steven Wort'),
(11, 'Jay Natarajan, Michael Coles, Rudi Bruchez, Scott Shaw'),
(12, 'Aahz Maruch, Stef Maruch'),
(13, 'Thiên Long'),
(14, 'Phạm Văn Ất'),
(15, 'Pham Van Hung'),
(16, 'Grokking'),
(17, '7 Up'),
(18, 'Bill gate');
INSERT INTO Member VALUES
(2737717304588825839, 'son', '$2a$10$I2gIr21CXXZ13Zp6O4YbPOl4MhRK.dIHEAfoIPoH1qaJdiCcFTvoC', 'son@gmail.com', 'Hong Son', 0, '2018-10-19 11:00:41', NULL),
(3421842250477308203, 'admin', '$2a$10$ds4H8yR99pgTudUBI3h7T.9tpBPWIx3rSDCRQdVFn9ci2NgTgf8f6', 'admin@yahoo.com.vn','admin', 0,  '2018-10-09 23:31:33', NULL),
(4761811720233120523, 'admin2', '$2a$10$bSgiw2AJXZ0PsIxQgwfzjeMO8k6kCqRm9C7Kih5/qfG4/UOGyHmei', 'admin@yahoo.com.vn', 'admin2', 0, '2018-10-09 23:58:49', NULL);
INSERT INTO Publisher VALUES
(1, 'Appress'),
(2, 'Reilly'),
(3, 'Thiên Long'),
(4, 'Ky thuat Ha Noi'),
(5, 'DHQG HCM'),
(6, 'Dong Nai'),
(7, '7 Up');
INSERT INTO Product VALUES
(1, 8, 1, 1, '1484236394', 'Design Patterns in C#', 455, 2018, 'PDF', '14.5 MB', 'In the first part of Design Patterns in C#, you will cover the 23 Gang of Four (GoF) design patterns, before moving onto some alternative design patterns, including the Simple Factory Pattern, the Null Object Pattern, and the MVC Pattern. The final part winds up with a conclusion and criticisms of design patterns with chapters on anti-patterns and memory leaks. By working through easy-to-follow examples, you will understand the concepts in depth and have a collection of programs to port over to your own projects.', '', 'Design-Patterns-in-C.jpg', 100000),
(2, 8, 1, 2, '1484230175', 'Pro C# 7-8th Edition', 1372, 2017, 'PDF', '29.5 MB', 'Ky la', '', 'Pro-C-7-8th-Edition.jpg', 100000),
(3, 9, 1, 3, '0672337940', 'Java in 24 Hours, Sams Teach Yourself (Covering Java 9), 8th Edition', 448, 2017, 'PDF', '5.6 MB', 'Computer programming with Java is easier than it looks. In just 24 lessons of one hour or less, you can learn to write computer programs in Java. Using a straightforward, step-by-step approach, popular author Rogers Cadenhead helps you master the skills and technology you need to create desktop', '', 'Java-in-24-Hours-Sams-Teach-Yourself-Covering-Java-9-8th-Edition-400x490.jpg', 100000),
(4, 9, 1, 4, '1484230418', N'Pro JavaFX 9, 4th Edition', 348, 2018, 'PDF', '6.2 MB', 'Use the JavaFX platform to create rich-client Java applications and discover how you can use this powerful Java-based UI platform, which is capable of handling large-scale data-driven business applications for PC as well as mobile and embedded devices. The expert authors cover the new more modular JavaFX 9 APIs', '', 'Pro-JavaFX-9-4th-Edition.jpg', 100000),
(5, 9, 2, 5, '1491934115', N'Data Science with Java', 236, 2017, 'PDF', '7.1 MB', 'Ky la', '', 'Data-Science-with-Java.jpg', 100000),
(6, 11, 1, 6, '1484234499', N'Advanced Data Analytics Using Python', 186, 2018, 'PDF', '2.1 MB', 'Ok', '', 'Advanced-Data-Analytics-Using-Python.jpg', 100000),
(7, 9, 1, 7, '1119235553', N'Java For Dummies, 7th Edition', 504, 2014, 'PDF', '12.6 MB', 'A new edition of the bestselling guide to Java\r\nIf you want to learn to speak the world’s most popular programming language like a native, Java For Dummies is your ideal companion. With a focus on reusing existing code, it quickly and easily shows you how to create basic Java objects, work with Java classes and methods, understand the value of variables, learn to control program flow with loops or decision-making statements, and so much more!\r\nJava is everywhere, runs on almost any computer, and is the engine that drives the coolest applications. Written for anyone who’s ever wanted to tackle programming with Java but never knew quite where to begin, this bestselling guide is your ticket to success! Featuring updates on everything you’ll encounter in Java 9—and brimming with tons of step-by-step instruction—it’s the perfect resource to get you up and running with Java in a jiffy!', '', 'Java-For-Dummies-7th-Edition.jpg', 100000),
(8, 13, 1, 8, '1484219546', N'Beginning SQL Queries, Second Edition', 250, 2016, 'PDF', '20.9 MB', 'Anyone who does any work at all with databases needs to know something of SQL. This is a friendly and easy-to-read guide to writing queries with the all-important – in the database world – SQL language. The author writes with exceptional clarity', '', 'Beginning-SQL-Queries.jpg', 100000),
(9, 13, 1, 9, '1430224649', N'Expert SQL Server 2008 Encryption', 320, 2009, 'PDF', '3.18 MB', 'Every day, organizations large and small fall victim to attacks on their data. Encryption provides a shield to help defend against intruders. Because of increasing pressure from government regulators, consumers, and the business community at large, the job descriptions of SQL DBAs and developers are expanding to include encryption. Expert SQL Server 2008 Encryption will show you how to efficiently implement SQL Server 2008 encryption functionality and features to secure your organizational data', '', '4056a343e83f1df.jpeg', 100000),
(10, 13, 1, 10, '9781118106884', N'Professional Microsoft SQL Server 2012 Administration', 936, 2012, 'PDF', '93.1 MB', 'Microsoft SQL Server 2012 will have major changes throughout the SQL Server and will impact how DBAs administer the database. With this book, a team of well-known SQL Server experts introduces the many new features of the most recent version of SQL Server and deciphers how these changes will affect the methods that administrators have been using for years. Loaded with unique tips, tricks, and workarounds for handling the most difficult SQL Server admin issues, this how-to guide deciphers topics such as performance tuning, backup and recovery, scaling and replication, clustering, and security.', '', '295557fd027de7f.jpg', 100000),
(11, 13, 1, 1, '9781430245964', N'Pro T-SQL 2012 Programmer’s Guide, 3rd Edition', 696, 2012, 'PDF', '18.9 MB', 'Pro T-SQL 2012 Programmer’s Guide is every developer’s key to making full use of SQL Server 2012’s powerful, built-in Transact-SQL language. Discussing new and existing features, the book takes you on an expert guided tour of Transact-SQL functionality. Fully functioning examples and downloadable source code bring technically accurate and engaging treatment of Transact-SQL into your own hands. Step-by-step explanations ensure clarity, and an advocacy of best-practices will steer you down the road to success.\r\n\r\nTransact-SQL is the language developers and DBAs use to interact with SQL Server. It’s used for everything from querying data, to writing stored procedures, to managing the database. New features in T-SQL 2012 include full support for window functions, stored sequences, the ability to throw errors, data paging, and more. All these important new features are covered in this book', '', '295557fd07764c9.jpg', 100000),
(12, 11, 2, 12, '0471778648', N'Python For Dummies', 432, 2006, 'PDF', '1.7 MB', 'Python is one of the most powerful, easy-to-read programminglanguages around, but it does have its limitations. This generalpurpose, high-level language that can be extended and embedded is asmart option for many programming problems, but a poor solution toothers.\r\nPython For Dummies is the quick-and-easy guide to gettingthe most out of this robust program. This hands-on book will showyou everything you need to know about building programs, debuggingcode, and simplifying development, as well as defining what actionsit can perform. You’ll wrap yourself around all of itsadvanced features and become an expert Python user in no time. Thisguide gives you the tools you need to', '', 'Python-For-Dummies.jpg', 100000),
(13, 18, 3, 13, '8935001810087', N'Bút Lông Bảng Thiên Long TL WB.03', 10, 2018, 'Fly', '10', 'Bút được sản xuất theo công nghệ hiện đại , đạt tiêu chuẩn an toàn quốc tế\n\nViết tốt , trơn , êm trơn bảng trắng , thủy tinh và những bề mặt nhẵn bóng\n\nBề rộng nét viết 2.5mm', '', 'cea9ce2d56b921055f39dbfbfdfc1894.jpg', 100000),
(14, 10, 4, 14, '8935095624539', N'GIÁO TRÌNH C++ VÀ LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG', 300, 2017, 'Book', '3 x 4', 'Lập trình cấu trúc là phương pháp tổ chức, phân chia chương trình thành các hàm, thủ tục, chúng được dùng để xử lý dữ liệu nhưng lại tách rời các cấu trúc dữ liệu. Thông qua các ngôn ngữ Foxpro, Pascal, C đa số những người làm Tin học đã khá quen biết với phương pháp lập trình này.\n\n \n\nLập trình hướng đối tượng dựa trên việc tổ chức chương trình thành các lớp. Khác với hàm và thủ tục, lớp là một đơn vị bao gồm cả dữ liệu và các phương thức xử lý. Vì vậy lớp có thể mô tả các thực thể một cách chân thực, đầy đủ cả phần dữ liệu và yêu cầu quản lý. Tư tưởng lập trình hướng đối tượng được áp dụng cho hầu hết các ngôn ngữ mới chạy trên môi trường Windows như Microsoft Access, Visual Basic, Visual C. Vì vậy việc nghiên cứu phương pháp lập trình mới này là rất cần thiết đối với tất cả những người quan tâm, yêu thích Tin học', '', '8935095624539.jpg', 100000),
(15, 13, 5, 15, '9786047355020', N'Big Data và ứng dụng trong kinh doanh', 350, 2018, 'Book', '20 x 30', 'Trong những năm gần đây, một thuật ngữ trong công nghệ thông tin được nhiều người quan tâm phải kể đến là Big Data (Dữ liệu lớn). Big Data là dữ liệu vượt quá khả năng xử lý của các hệ thống cơ sở dữ liệu thông thường, dữ liệu quá lớn, di chuyển quá nhanh hoặc không phù hợp với kiến trúc cơ sở dữ liệu hiện tại. Để thu được giá trị từ dữ liệu này, người ta phải chọn một cách khác để xử lý nó.', '', '2017-09-14-04-56-03_image002.jpg', 100000),
(16, 16, 6, 16, '9786045265840', N'Dijkstra - Ấn Phẩm Chuyên Đề Cho Kỹ Sư Phần Mềm Người Việt ', 30, 2018, 'Magezine', '70 x 80', 'Bạn đang cầm trên tay tập đầu tiên của ấn phẩm Dijkstra - Ấn Phẩm Chuyên Đề Cho Kỹ Sư Phần Mềm Người Việt - kết quả của một thời gian dài thai nghén ý tưởng của đội ngũ Grokking Vietnam.\n\nTrong ấn phẩm này, nhóm biên soạn sẽ cố gắng cung cấp những bài viết chuyên sâu về lĩnh vực công nghệ phần mềm, những bài phân tích kiến trúc, những bài viết về văn hóa, cộng đồng và các bài viết về kiến thức nền tảng khoa học máy tính. Để đảm bảo tính chính xác cũng như tính cập nhật, những bài viết này sẽ được viết bởi chính những kỹ sư phần mềm đang làm việc trong những công ty phần mềm tại Việt Nam hoặc nước ngoài', '', '75a3c5e390d6942c8042f36637947a5e.jpg', 100000),
(17, 18, 7, 17, '8934588843051', N'Nước ngọt Revive chai 390ml', 1, 2018, 'Chai', '390 ml', 'Nước ngọt được sản xuất trên dây chuyền hiện đại chiết xuất từ nước bão hòa CO2, đường sucrose và destrose, chất điều chỉnh độ axit, chất điện giải... không chứa chất bảo quản và hóa chất độc hại, an toàn cho người sử dụng.\nVới chất điện giải Natri, Kali... và vitamin B3, B6, B12 giúp bù nước, muối khoáng bị mất đi nhanh chóng do vận động, chơi thể thao.', '', '7up-revive-pet-390ml-2-700x467-1.jpg', 100000);
INSERT INTO Status VALUES
(1, 'Processing'),
(2, 'Confirm'),
(3, 'Delivered');
INSERT INTO Invoice VALUES
('af8i2wvoqY1PZwBuKucvQFZuiVhx4A3D', NULL, 'npthanhthai@yahoo.com.vn', '1234234', 'hcm', 1, '2018-10-17 23:37:37');
INSERT INTO InvoiceDetail VALUES 
('af8i2wvoqY1PZwBuKucvQFZuiVhx4A3D', 1, 1, 100000);
INSERT INTO Role VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_MEMBER');
INSERT INTO MemberInRole VALUES
(1, 2737717304588825839),
(1, 4761811720233120523);