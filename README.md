HW2

根據 Clean Architecture 進行分層，建立 `entities`、`usecases`、`adapters`、`app` 資料夾

app 資料夾裡的 TaskListApp 透過 CommandController 以及 CommandIn 利用 execute method 執行對應的 Command 功能於 usecase 層採用 DTO 避免將 entities 帶出，導致違反跨層原則，接著將 CommandOut 帶出給 CommandPresenter 利用 exeOut method 得到輸出(String)，TaskListApp 依據 PrintWriter 的 out 將輸出結果輸出到 console。

repository 未完成


HW1

利用 Replace Conditional with Polymorphism 將 TaskList 的 execute method 拆解，並將使用到的 method 搬到對應的class裡
