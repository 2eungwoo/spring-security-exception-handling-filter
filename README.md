## spring-security-exception-handling-filter
> In Spring Boot, excpetions thrown from `@RestControllerAdvice` </br>
(such as a `GlobalExceptionHandler`) can not catch excepthions that occur within `Spring Security Filters`

> To handle these exceptions properly`(authentication/authorization`),</br> we need to make our own `customExceptionHandlers` that intercepts and processes the exceptions at the correct point the the filter chain

## blog
> [link]()

## how to test : 
### 📌 Scenario A
1. request to protected API without logging in
> Scenario: An unauthenticated user tries to access a secured endpoint (/secure/hello)
```shell
curl -X GET http://localhost:8080/secure/hello
```
Expected:
```json
{
  "message":"로그인이 필요합니다."
}
```
➡️ Handled by: `CustomAuthenticationEntryPoint`</br>
➡️ HTTP Status: `401 Unauthorized`

### 📌 Scenario B
2. request to admin-only API after loggin in as a normal user
> Scenario: A logged-in user (with USER role) tries to access an admin-only endpoint (/secure/admin)
```shell
curl -X POST http://localhost:8080/login \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=test&password=1234" \
  -c cookies.txt && \
curl -X GET http://localhost:8080/secure/admin -b cookies.txt
```
Expected:
```json
{
  "message": "접근 권한이 없습니다."
}
```
➡️ Handled by: `CustomAccessDeniedHandler`</br>
➡️ HTTP Status: `403 Forbidden`



## etc
> updated in 2025.07.06
