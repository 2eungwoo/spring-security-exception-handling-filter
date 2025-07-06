## spring-security-exception-handling-filter
> In Spring Boot, excpetions thrown from `@RestControllerAdvice` </br>
(such as a `GlobalExceptionHandler`) can not catch excepthions that occur within `Spring Security Filters`

> To handle these exceptions properly`(authentication/authorization`),</br> we need to make our own `customExceptionHandlers` that intercepts and processes the exceptions at the correct point the the filter chain

## blog
> [link]()

## how to test
> user login -> need auth api call
```shell
curl -X POST http://localhost:8080/login \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=test&password=1234" \
  -c cookies.txt && \
curl -X GET http://localhost:8080/secure/hello -b cookies.txt 
```
you might have result like
```
Secure Hello
```

---
> user login -> admin only api call
```shell
curl -X POST http://localhost:8080/login \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=test&password=1234" \
  -c cookies.txt && \
curl -X GET http://localhost:8080/secure/admin -b cookies.txt
```
you might have result like
```
Admin Only
```

## etc
> updated in 2025.07.06
