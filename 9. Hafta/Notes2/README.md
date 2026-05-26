# Notes App

Bu proje, Jetpack Compose ve Room Persistence Library kullanılarak geliştirilmiş, modern bir Android not alma uygulamasıdır. Kullanıcıların verilerini yerel bir SQLite veritabanında güvenli ve kalıcı bir şekilde saklamasına olanak tanır.

## Temel Özellikler

- Yeni not oluşturma (Başlık ve içerik).
- Mevcut notları listeleme.
- Notları düzenleme ve güncelleme.
- Notları kalıcı olarak silme.
- Notların oluşturulma veya düzenlenme tarihlerini görüntüleme.
- Uygulama kapatılsa bile verilerin SQLite üzerinde korunması.

## Mimari Yapı

Uygulama, verilerin yönetimini, iş mantığını ve arayüzü birbirinden ayırmak için MVVM (Model-View-ViewModel) mimari modelini kullanır:

- **Model (Data Layer):** Room kütüphanesi kullanılarak SQLite veritabanı işlemlerini yönetir. `Note` (Entity), `NoteDao` (Veri Erişim Nesnesi) ve `AppDatabase` bileşenlerinden oluşur.
- **ViewModel:** Veritabanı ile UI arasındaki iletişimi sağlar. Verileri reaktif bir şekilde (Flow) UI katmanına sunar ve kullanıcı işlemlerini arka planda (Coroutines) yürütür.
- **View (UI Layer):** Jetpack Compose kullanılarak geliştirilen modern ve deklaratif bir arayüzdür. Material 3 bileşenlerini temel alır.

## Dosya Yapısı ve Görevleri

- **MainActivity.kt:** Uygulamanın giriş noktasıdır ve tüm kullanıcı arayüzü (Scaffold, Listeler, Diyaloglar) burada tanımlanır.
- **NoteViewModel.kt:** Not ekleme, silme ve güncelleme gibi iş mantığını koordine eder.
- **data/Note.kt:** Veritabanındaki "notes" tablosunun kolonlarını belirleyen veri sınıfıdır.
- **data/NoteDao.kt:** SQL sorgularının (SELECT, INSERT, DELETE) tanımlandığı arayüzdür.
- **data/AppDatabase.kt:** Room veritabanı yapılandırmasını ve bağlantı yönetimini (Singleton) içerir.
- **ui/theme/:** Uygulamanın renk, yazı tipi ve genel stil temalarını belirleyen konfigürasyon dosyalarını içerir.

## Teknik Detaylar

- **Dil:** Kotlin
- **UI:** Jetpack Compose
- **Veritabanı:** SQLite (Room Persistence Library)
- **Asenkron İşlemler:** Coroutines ve Flow
- **Bağımlılık Yönetimi:** Kotlin Symbol Processing (KSP) ve Version Catalogs (libs.versions.toml)
