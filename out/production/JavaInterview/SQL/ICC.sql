/*
   Write query in a way that will provide the below output as how many each team got wins

   CREATE TABLE [dbo].[ICC](
	[Team_1] [nvarchar](50) NULL,
	[Team_2] [nvarchar](50) NULL,
	[Winner] [nvarchar](50) NULL
  )

  INSERT [dbo].[ICC] ([Team_1], [Team_2], [Winner]) VALUES (N'India', N'SL', N'India')
  INSERT [dbo].[ICC] ([Team_1], [Team_2], [Winner]) VALUES (N'SL', N'Aus', N'Aus')
  INSERT [dbo].[ICC] ([Team_1], [Team_2], [Winner]) VALUES (N'SA', N'Eng', N'Eng')
  INSERT [dbo].[ICC] ([Team_1], [Team_2], [Winner]) VALUES (N'Eng', N'NZ', N'NZ')
  INSERT [dbo].[ICC] ([Team_1], [Team_2], [Winner]) VALUES (N'Aus', N'India', N'India')

  Input table

  Team_1	Team_2	Winner
  India	    SL	    India
  SL	    Aus	    Aus
  SA	    Eng	    Eng
  Eng	    NZ	    NZ
  Aus	    India	India

  Output table

  Team_name   Matches_played   no_of_wins  no_of_losses
  India            2
  SL               2
  SA               1
  Eng              2
  Aus              2
  NZ               1

*/

SELECT Team, COUNT(Team) AS Matches_played, SUM(Win) AS no_of_wins, (COUNT(Team) - SUM(Win)) AS no_of_losses FROM
(SELECT [Team_1] AS Team, Winner, CASE WHEN Team_1 = Winner THEN 1 ELSE 0 END AS Win FROM ICC
UNION ALL
SELECT [Team_2] AS Team, Winner, CASE WHEN Team_2 = Winner THEN 1 ELSE 0 END AS Win FROM ICC) AS Temp
GROUP BY Team Order by SUM(Win) desc

