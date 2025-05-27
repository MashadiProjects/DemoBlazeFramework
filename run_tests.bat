@echo off
echo Running DemoBlaze tests...
mvn clean test
echo.
echo Opening Extent Report...
start "" "target/extent-report/index.html"
pause
