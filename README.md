HW5

根據上課修改 entites layer 以 teddysoft.ezddd 來定義aggregateRoot(新增 ProjectListID)、entity、valueObject，並且添加ReadOnlyTask、ReadOnlyProject 避免修改

HW4

根據上課修改 entites layer 修改 ProjectList 並且修改 ProjectList 相關的函式，並且修改 usecases -> Command -> 每一個(CommandMethod) executeCommand 將抽出的函式inline回去

HW3

根據上課修改 entites layer 新增 record ProjectName 並修改 TaskId 為 record 並且修改 ProjectList 以及相關的函式


HW2

根據 Clean Architecture 進行分層，建立 `entities`、`usecases`、`adapters`、`app` 資料夾

app 資料夾裡的 TaskListApp 透過 CommandController 以及 CommandIn 利用 execute method 執行對應的 Command 功能，接著將 CommandOut 帶出給 CommandPresenter 利用 exeOut method 得到輸出(String)，TaskListApp 依據 PrintWriter 的 out 將輸出結果輸出到 console。


HW1

利用 Replace Conditional with Polymorphism 將 TaskList 的 execute method 拆解，並將使用到的 method 搬到對應的class裡
