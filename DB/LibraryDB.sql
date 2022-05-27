USE [master]
GO
/****** Object:  Database [Library]    Script Date: 5/27/2022 2:23:27 PM ******/
CREATE DATABASE [Library]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Library', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Library.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Library_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Library_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Library] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Library].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Library] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Library] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Library] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Library] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Library] SET ARITHABORT OFF 
GO
ALTER DATABASE [Library] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Library] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Library] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Library] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Library] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Library] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Library] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Library] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Library] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Library] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Library] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Library] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Library] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Library] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Library] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Library] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Library] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Library] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Library] SET  MULTI_USER 
GO
ALTER DATABASE [Library] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Library] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Library] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Library] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Library] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Library] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Library] SET QUERY_STORE = OFF
GO
USE [Library]
GO
/****** Object:  Table [dbo].[Books]    Script Date: 5/27/2022 2:23:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books](
	[Book_id] [int] IDENTITY(1,1) NOT NULL,
	[Book_title] [nvarchar](40) NOT NULL,
	[Book_publisher] [nvarchar](40) NOT NULL,
	[Book_genre] [nvarchar](40) NOT NULL,
	[Book_author] [nvarchar](40) NOT NULL,
	[Published_year] [nvarchar](40) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Issued_books]    Script Date: 5/27/2022 2:23:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Issued_books](
	[Issue_id] [int] IDENTITY(1,1) NOT NULL,
	[Issue_date] [date] NOT NULL,
	[Period] [int] NOT NULL,
	[User_id] [int] NULL,
	[Book_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Issue_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Returned_books]    Script Date: 5/27/2022 2:23:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Returned_books](
	[Return_id] [int] IDENTITY(1,1) NOT NULL,
	[Return_date] [date] NOT NULL,
	[Period] [int] NOT NULL,
	[User_id] [int] NULL,
	[Book_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Return_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 5/27/2022 2:23:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[User_id] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](40) NOT NULL,
	[LastName] [nvarchar](40) NOT NULL,
	[Age] [int] NOT NULL,
	[Gender] [nvarchar](40) NOT NULL,
	[StudentEmail] [nvarchar](50) NOT NULL,
	[StudentPassword] [nvarchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[User_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Issued_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Issued_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Issued_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Issued_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Issued_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Issued_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([Book_id])
REFERENCES [dbo].[Books] ([Book_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Returned_books]  WITH CHECK ADD FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
GO
USE [master]
GO
ALTER DATABASE [Library] SET  READ_WRITE 
GO
