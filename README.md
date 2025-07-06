## spring-security-exception-handling-filter
> In Spring Boot, excpetions thrown from `@RestControllerAdvice` </br>
(such as a `GlobalExceptionHandler`) can not catch excepthions that occur within `Spring Security Filters`

> To handle these exceptions properly`(authentication/authorization`),</br> we need to make our own `customExceptionHandlers` that intercepts and processes the exceptions at the correct point the the filter chain

## blog
> [link]()

## etc
> updated in 2025.07.06
