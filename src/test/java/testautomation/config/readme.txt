
-Login ve Favori restoran fonksiyonları test edildi.
-Parallel ve crossbrowser koşması için browser tagları kullanıldı (@chrome , @firefox).
-Koşması istenen feature lar "@ui" ile taglenebilir.
-Feature'lar her browser için çoklandı.
-/run/Runner içerisinden koşacak tagler belirtilebilir (@ui)

/pages altında PageObjectlerde sayfalara ait fonksiyonların methodları.

/utils/DriverFactory :  cucumber taglerı ile browser başlatılması,sonlandırılması ve fail durumunda screenshot methodları.
/utils/Helper : webdriver için basitleştirilmiş methodlar.
utils/WebdriverUtils : webdriver yaratılması, kill edilmesi.

Hata alan senaryolara ait screenshot /target altına çıkıyor.
Test Raporu;  /target/cucumber-reports/cucumber-html-reports içerisinde bulunuyor /tüm senaryolar için: (ui.html).


