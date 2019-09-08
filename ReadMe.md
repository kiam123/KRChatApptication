# 聊天室
## 需求
1. 使用者需要一個註冊界面，並且可以把使用者的資料存下來
2. 使用者需要一個登入的界面
3. 使用者登入以後，可以知道目前的在線和不在線的人數
4. 使用者登入以後，需要告訴其他朋友，他已經上線了
5. 使用者下線的時候，會告訴大家下線
6. 使用者在不同的平台上登入也可以重複登入
7.  使用者與朋友2文字聊天
    * 聊天記錄  
        - 資料庫中無聊天記錄 則 無動作
        - 資料庫中有聊天記錄 則
            1. 從資料庫中取得最新的25筆資料 若無25筆 則 也會取得25筆以內的資料
            2. 從資料庫中取得最新的25筆資料 超過25筆 則 只取得25筆資料，若往上滑到最後的25筆資料 則 往上加入25筆(條件a可能會出現)
    * 發送信息
        - 朋友2在線(app開著的情況)
            - 不在聊天框內
                1. 發送信息給朋友2，並且把信息、日期和時間(時分秒)存進 資料庫/檔案 中，並且 發送notification + 鈴聲通知 則 狀態設為 未讀
            - 在同一個聊天框內
                1. 發送信息給朋友2，並且把信息、日期和時間(時分秒)存進 資料庫/檔案 中 則狀態為 已讀  
        - 朋友2不在線(app關著的情況)
            - 若socket存在則發送 notification + 鈴聲通知，並且把信息、日期和時間(時分秒)存進 資料庫/檔案 中 則狀態為 未讀  
8. 使用者與朋友2語音聊天
    * 朋友2在線(app開著的情況)
        - app界面出現語音聊天畫面
            1. 接通以後可以進行聊天
            2. 拒絕以後，資料庫/檔案 記錄
                - 若在聊天框中則聊天框出現未接對方電話 (已讀)
                - 若不在聊天框中則聊天框出現未接對方電話 (未讀)
    * 朋友2不在線(app關著的情況)
        - app界面出現語音聊天畫面
            1. 接通以後可以進行聊天
            2. 拒絕以後，資料庫/檔案 記錄
                - 若在聊天框中則聊天框出現未接對方電話 (已讀)
                - 若不在聊天框中則聊天框出現未接對方電話 (未讀)
9. 使用者與朋友2視訊聊天
    * 朋友2在線(app開著的情況)
        - app界面出現語音聊天畫面
            1. 接通以後可以進行聊天
            2. 拒絕以後，資料庫/檔案 記錄
                - 若在聊天框中則聊天框出現未接對方視訊電話 (已讀)
                - 若不在聊天框中則聊天框出現未接對方視訊電話 (未讀)
    * 朋友2不在線(app關著的情況)
        - app界面出現語音聊天畫面
            1. 接通以後可以進行聊天
            2. 拒絕以後，資料庫/檔案 記錄
                - 若在聊天框中則聊天框出現未接對方視訊電話 (已讀)
                - 若不在聊天框中則聊天框出現未接對方視訊電話 (未讀)
10. 搜尋好友
    * 好友
        - 顯示好友 在線/不在線
        - 可以與好友聊天
    * 非好友
        - 顯示可以加好友
        - 可以與非好友聊天

## 資料庫


## 架構圖


## App界面
