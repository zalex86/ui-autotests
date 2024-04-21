# Project for UI tests

To run local tests it needs to add the following text to:
**Run/Debug Configurations -> Edit configuration templates... -> TestNG -> VM options**
```
-DgridBrowserName="chrome"
-Dserver="https://test.com/"
```
