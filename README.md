# RaiffeisenTest
App for Raiffeisen interview

## Modules

```bash
:app
:core:designsystem
:core:navigation
:core:network
:core:translations
:core:util
:data:model:user
:data:user
:feature:home
:feature:user
```

## Screens

#### 1. Home Screen - Drawer navigation
 - User List Screen
#### 2. User Details Screen


## Notes

1. ```:core:navigation``` contains ```NavigationDispatcher``` that is used to navigate between ```Home Screen``` and ```User Details Screen```
2. ```Retrofit``` used for networking
3. ```Koin``` used for dependency injection
4. ```Coil``` for user image loading, fallback with name initial
5. ```Paging3``` used for pagination, personally prefer to do it manually for flexibility when more features are required
6. ```Mockk``` and ```Screenshot Testing``` used; in absence of much time I didn't write all tests
7. Copied the theme from ```https://medium.com/mobile-app-development-publication/theming-in-compose-5f64ce08256c``` and focused on functionality rather than UI
8. Mapped the ```age``` and ```time``` to ```dob``` field from API response
9. Didn't find any ```Boolean``` values to map to attachment and star icons

## Screenshots
<img width="345" alt="Screenshot 2024-11-26 at 00 15 58" src="https://github.com/user-attachments/assets/3088d355-629a-476b-a3db-c8c16cbd57c0">
<img width="343" alt="Screenshot 2024-11-26 at 00 16 09" src="https://github.com/user-attachments/assets/862028c9-9234-4367-8620-b7905c3a9563">
<img width="347" alt="Screenshot 2024-11-26 at 00 16 18" src="https://github.com/user-attachments/assets/8110dc80-3d24-45c4-aade-5018e7283460">
