# 聊天室
## 需求(App)
1. 使用者需要一個註冊界面，並且可以把使用者的資料存下來
2. 使用者需要一個登入的界面
3. 使用者登入以後，可以知道目前的在線和不在線的人數
4. 使用者登入以後，需要告訴其他朋友，他已經上線了
5. 使用者下線的時候，會告訴大家下線
6. 使用者在不同的平台上登入也可以重複登入
7.  使用者與好友文字聊天
    * 聊天記錄  
        - 資料庫中無聊天記錄 則 無動作
        - 資料庫中有聊天記錄 則
            1. 從資料庫中取得最新的25筆資料 若無25筆 則 也會取得25筆以內的資料
            2. 從資料庫中取得最新的25筆資料 超過25筆 則 只取得25筆資料，若往上滑到最後的25筆資料 則 往上加入25筆(條件a可能會出現)
    * 發送信息
        - 好友在線(app開著的情況)
            - 不在聊天框內
                1. 發送信息給好友，並且把信息、日期和時間(時分秒)存進 資料庫/檔案 中，並且 發送notification + 鈴聲通知 則 狀態設為 未讀
            - 在同一個聊天框內
                1. 發送信息給好友，並且把信息、日期和時間(時分秒)存進 資料庫/檔案 中 則狀態為 已讀  
        - 好友不在線(app關著的情況)
            - 若socket存在則發送 notification + 鈴聲通知，並且把信息、日期和時間(時分秒)存進 資料庫/檔案 中 則狀態為 未讀  
8. 使用者與好友語音聊天
    * 好友在線(app開著的情況)
        - app界面出現語音聊天畫面
            1. 接通以後可以進行聊天
            2. 拒絕以後，資料庫/檔案 記錄
                - 若在聊天框中則聊天框出現未接對方電話 (已讀)
                - 若不在聊天框中則聊天框出現未接對方電話 (未讀)
    * 好友不在線(app關著的情況)
        - app界面出現語音聊天畫面
            1. 接通以後可以進行聊天
            2. 拒絕以後，資料庫/檔案 記錄
                - 若在聊天框中則聊天框出現未接對方電話 (已讀)
                - 若不在聊天框中則聊天框出現未接對方電話 (未讀)
9. 使用者與好友視訊聊天
    * 好友在線(app開著的情況)
        - app界面出現語音聊天畫面
            1. 接通以後可以進行聊天
            2. 拒絕以後，資料庫/檔案 記錄
                - 若在聊天框中則聊天框出現未接對方視訊電話 (已讀)
                - 若不在聊天框中則聊天框出現未接對方視訊電話 (未讀)
    * 好友不在線(app關著的情況)
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

## 需求(對應後端)
1. 資料庫新增一個 用戶賬號、密碼、姓、名   
2. 需要從資料庫查詢使用者的 賬號、密碼 是否是正確的
3. 從資料庫中查詢使用者的 好友 在線狀況
4. 資料庫需要修改在線的狀態，然後後端需要告訴使用者的朋友  他已經上線了
5. 資料庫需要修改在線的狀態，然後後端需要告訴使用者的朋友  他已經下線了
6. 資料庫需要記錄是用 哪一些平台登入
7. 使用者與朋友2文字聊天(敘述)  
        * 聊天記錄(敘述)  
            1. 從資料庫查詢使用者與朋友聊天記錄 無資料 則回傳 0  
            2. 從資料庫查詢使用者與朋友聊天記錄 有25筆資料 則回傳25筆  無25筆資料 則回傳25筆內的資料就結束。  
            3. 使用者往上滑 程式會繼續取得資料 繼續利用條件2  
        * 發送信息(敘述)  
            - 朋友2在線(app開著的情況)(敘述)  
                - 不在聊天框內(敘述)  
                    1. 資料庫 新增 信息、日期、時間(時分秒)和未讀 存進資料庫/檔案
                - 在同一個聊天框內(敘述)  
                    1. 資料庫 新增 信息、日期、時間(時分秒)和已讀 存進資料庫/檔案  
            - 朋友2不在線(app關著的情況)(敘述)  
                1. 程式會發送notification + 鈴聲通知給使用者。資料庫 新增 信息、日期、時間(時分秒)和未讀 存進資料庫/檔案  
8. 使用者與朋友2語音聊天(敘述)  
    * 朋友2在線(app開著的情況)(敘述)  
        - app界面出現語音聊天畫面  
            1. 資料庫會儲存 聊天語音、日期、時間(時分秒)和已讀  
            2. 拒絕以後，資料庫/檔案 記錄(敘述)  
                - 資料庫會儲存 聊天語音、日期、時間(時分秒)和已讀  
                - 資料庫會儲存 聊天語音、日期、時間(時分秒)和未讀  
    * 朋友2不在線(app關著的情況)  
        - app界面出現語音聊天畫面  
            1. 資料庫會儲存 聊天語音、日期、時間(時分秒)和已讀  
            2. 拒絕以後，資料庫/檔案 記錄(敘述)  
                - 資料庫會儲存 聊天語音、日期、時間(時分秒)和已讀  
                - 資料庫會儲存 聊天語音、日期、時間(時分秒)和未讀  
9. 使用者與朋友2視訊聊天  
    * 朋友2在線(app開著的情況)  
        - app界面出現語音聊天畫面  
            1. 資料庫會儲存 視訊、日期、時間(時分秒)和已讀  
            2. 拒絕以後，資料庫/檔案 記錄(敘述)  
                - 資料庫會儲存 視訊、日期、時間(時分秒)和已讀  
                - 資料庫會儲存 視訊、日期、時間(時分秒)和未讀  
    * 朋友2不在線(app關著的情況)  
        - app界面出現語音聊天畫面  
            1. 資料庫會儲存 視訊、日期、時間(時分秒)和已讀  
            2. 拒絕以後，資料庫/檔案 記錄(敘述)  
                - 資料庫會儲存 視訊、日期、時間(時分秒)和已讀  
                - 資料庫會儲存 視訊、日期、時間(時分秒)和未讀  
10. 搜尋好友  
    * 好友  
         - 資料庫查詢使用者的 是否是好友 若是好友 則 顯示在線状况，否者顯示不是好友  
         - 同上  
    * 非好友  
         - 資料庫查詢使用者的 是否是好友 若是好友 則 顯示在線状况，否者顯示不是好友  
         - 同上  
## 資料庫


## 架構圖


## App界面
