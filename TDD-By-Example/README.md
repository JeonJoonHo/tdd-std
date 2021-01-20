### **Chapter 1. 다중 통화를 지원하는 Money 객체**

보고서를 생성하기 위한 기능
1. 통화가 다른 두 금액을 더해서 주어진 환율에 맞게 변한 금액을 결과로 얻을 수 있어야 한다.
2. 어떤 금액(주가)을 어떤 수(주식의 수)에 곱한 금액을 결과로 얻을 수 있어야 한다.

Check list
- [ ] $5 + 10CHF = $10(환율이 2:1)
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기
- [ ] Dollar 부작용?
- [ ] Money 반올림?

지금까지 한 작업
- 우리가 작업해야 할 테스트 목록 작성
- 오퍼레이션이 외부에서 어떻게 보이길 원하는지 말해주는 이야기를 코드로 표현
- JUnit에 대한 상세한 사항은 잠시 무시
- Stub 구현을 통해 테스트 컴파일
- 끔직한 죄악을 범하여 테스트 통과
- 돌아가는 코드에서 상수를 변수로 변경하여 점진적으로 일반화
- 새로운 할일들을 한번에 처리하는 대신 할일 목록에 추가하고 넘어감

### **Chapter 2. 타락한 객체**

Check list
- [ ] $5 + 10CHF = $10(환율이 2:1)
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기
- [x] Dollar 부작용?
- [ ] Money 반올림?

지금까지 한 작업
- 설계상의 결함(Dollar SideEffect)으로 인해 실패하는 테스트로 변환
- Stub 구현으로 빠르게 컴파일 통과
- 올바르다고 생각하는 코드 구현

```
최대한 빨리 초록 막대(Success)를 보기 위한 세 가지 전략
1. 가짜로 구현 : 상수를 반환하게 만들고 진짜 코드를 얻을 때까지 단계적으로 상수를 변수로 변환
2. 명백한 구현 사용 : 실제 구현을 입력
```

### **Chapter 3. 모두를 위한 평등**

Dollar 객체는 Value Object Pattern 이다.
2장에서와 같이 모든 연산은 새 객체를 반환해야하고 $5와 $5는 같은 객체로 볼 수 있기 때문에 equals() 함수를 구현해야 한다.
만약, Dollar를 해시 테이블의 키로 사용할 예정이라면 hashCode()를 같이 구현해야 한다.
equals() 함수로 동일성은 확인 가능하지만 NULL 값이나 다른 객체 비교를 위한 함수도 구현해야 한다. 

Check list
- [ ] $5 + 10CHF = $10(환율이 2:1)
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기
- [x] Dollar 부작용?
- [ ] Money 반올림?
- [x] equals()
- [ ] hashCdoe()
- [ ] Equal Null
- [ ] Equal Object

지금까지 한 작업
- 디자인 패턴(값 객체)이 하나의 또 다른 오퍼레이션을 암시한다는 것을 확인
- 오퍼레이션 테스트
- 오퍼레이션을 간단히 구현
- 곧장 리팩토링을 하는 대신 테스트를 조금 더 함
- 두 경우를 모두 수용할 수 있도록 리팩토링

### **Chapter 4. 프라이버시**

Dollar 객체의 times 함수는 Dollar 객체를 반환하는데 
현재의 테스트는 기존 Dollar 객체와 반환된 Dollar 객체가 같다는 것을 증명해주지 않고 있다.

테스트에서 Dollar 객체의 amount를 비교하는 것이 아닌 객체 자체를 비교해 일치하다는 것을 증명 하자.

이제 객체의 amount는 자기 자신만 호출하기 때문에 private으로 변경할 수 있다.

Check list
- [ ] $5 + 10CHF = $10(환율이 2:1)
- [x] $5 x 2 = $10
- [x] amount를 private으로 만들기
- [x] Dollar 부작용?
- [ ] Money 반올림?
- [x] equals()
- [ ] hashCdoe()
- [ ] Equal Null
- [ ] Equal Object

지금까지 한 작업
- 오직 테스트를 향상시키기 위해서만 개발된 기능을 사용
- **두 테스트가 동시에 실패하면 망한다는 점을 인식**
- 위험 요소가 있음에도 계속 진행
- 테스트와 코드 사이의 결합도를 낮추기 위해, 테스트하는 객체의 새 기능을 사용

### **Chapter 5. 솔직히 말하자면**

첫 번째 Check List를 테스트로 구현하기 위해 Franc 객체를 생성한다
일단은 Dollar 객체와 비슷한 Franc 객체를 생성한다

Check list
- [ ] $5 + 10CHF = $10(환율이 2:1)
- [x] $5 x 2 = $10
- [x] amount를 private으로 만들기
- [x] Dollar 부작용?
- [ ] Money 반올림?
- [x] equals()
- [ ] hashCdoe()
- [ ] Equal Null
- [ ] Equal Object
- [x] 5CHF x 2 = 10CHF
- [ ] Dollar/Franc 중복
- [ ] 공용 equals
- [ ] 공용 times

지금까지 한 작업
- 큰 테스트를 공략할 수 없기 때문에 자그마한 테스트부터 생성
- 중복을 만들고 조금 고쳐서 테스트 작성
- 모델 코드도 복사하고 수정해서 테스트를 통과

```
구현 단계
1. 테스트 작성.
2. 컴파일되게 하기.
3. 실패하는지 확인하기 위해 실행.
4. 실행하게 만듦.
5. 중복 제거

1~4 단계는 빠른 속도로 진행.
5단계에서 적절한 설계, 올바른 코드를 만들어야 한다.
```

### **Chapter 6. 돌아온 '모두를 위한 평등'**

equals() 함수의 중복을 줄이기 위한 방법 필요하다.
중복을 줄이기 위해서는 상속을 사용하는 것이 좋지만, Dollar, Franc 두 클래스 중 하나가 상위 클래스가 되는 것이 아닌
공통된 상위 클래스를 생성하는 것이 바람직하다.

Check list
- [ ] $5 + 10CHF = $10(환율이 2:1)
- [x] $5 x 2 = $10
- [x] amount를 private으로 만들기
- [x] Dollar 부작용?
- [ ] Money 반올림?
- [x] equals()
- [ ] hashCdoe()
- [ ] Equal Null
- [ ] Equal Object
- [x] 5CHF x 2 = 10CHF
- [ ] Dollar/Franc 중복
- [x] 공용 equals
- [ ] 공용 times
- [ ] Dollar / Franc 비교하기

지금까지 한 작업
- 공통된 코드를 첫 번째 클래스(Dollar)에서 상위 클래스(Money)로 단계적으로 옮겼다.
- 두 번째 클래스(Franc)도 Money의 하위 클래스로 만들었다.
- 불필요한 구현을 제거하기 전에 두 equals() 구현을 일치시켰다.

### **Chapter 7. 사과와 오렌지**

Dollar와 Franc은 다른 화폐이다.
하지만 우리의 equals() 함수는? 고쳐야 한다.

Check list
- [ ] $5 + 10CHF = $10(환율이 2:1)
- [x] $5 x 2 = $10
- [x] amount를 private으로 만들기
- [x] Dollar 부작용?
- [ ] Money 반올림?
- [x] equals()
- [ ] hashCdoe()
- [ ] Equal Null
- [ ] Equal Object
- [x] 5CHF x 2 = 10CHF
- [ ] Dollar/Franc 중복
- [x] 공용 equals
- [ ] 공용 times
- [x] Dollar / Franc 비교하기
- [ ] 통화?

지금까지 한 작업
- 우릴 괴롭히던 결함을 끄집어내서 텍스트에 담아냈다.
- 완벽하진 않지만 그럭저럭 봐줄 만한 방법(getClass())으로 테스트를 통과하게 만들었다.
- 더 많은 동기가 있기 전에는 더 많은 설계를 도입하지 않기로 했다.

### **Chapter 8. 객체 만들기 **

클라이언트에서 하위 클래스의 존재를 알지 못하도록 분리(decoupling)가 필요.
하위 클래스의 존재를 분리하면 어떠한 모델 코드에도 영향을 주지 않고 상속 구조를 마음대로 변경할 수 있다.

Check list
- [ ] $5 + 10CHF = $10(환율이 2:1)
- [x] $5 x 2 = $10
- [x] amount를 private으로 만들기
- [x] Dollar 부작용?
- [ ] Money 반올림?
- [x] equals()
- [ ] hashCdoe()
- [ ] Equal Null
- [ ] Equal Object
- [x] 5CHF x 2 = 10CHF
- [ ] Dollar/Franc 중복
- [x] 공용 equals
- [ ] 공용 times
- [x] Dollar / Franc 비교하기
- [ ] 통화?
- [ ] testFrancMultiplication을 지워야 할까?

지금까지 한 작업
- 동일한 메서드(times)의 두 변이형 메서드 서명부를 통일시킴으로써 중복 제거를 향해 한 단계 더 전진했다.
- 최소한 메서드 선언부만이라도 공통 상위 클래스로 옮겼다.
- 팩토리 메서드를 도입해 테스트 코드에서 콘크리트 하위 클래스의 존재 사실을 분리해냈다.
- 하위 클래스가 사라지면 몇몇 테스트는 불필요한 여분의 것이 된다는 것을 인식했다. (testFrancMultiplication)

### **Chapter 9. 우리가 사는 시간 **

times 중복을 줄이기 위한 과정으로 통화 개념을 도입하자!

Check list
- [ ] $5 + 10CHF = $10(환율이 2:1)
- [x] $5 x 2 = $10
- [x] amount를 private으로 만들기
- [x] Dollar 부작용?
- [ ] Money 반올림?
- [x] equals()
- [ ] hashCdoe()
- [ ] Equal Null
- [ ] Equal Object
- [x] 5CHF x 2 = 10CHF
- [ ] Dollar/Franc 중복
- [x] 공용 equals
- [ ] 공용 times
- [x] Dollar / Franc 비교하기
- [x] 통화?
- [ ] testFrancMultiplication을 지워야 할까?

지금까지 한 작업
- 큰 설계 아이디어를 다루다가 조금 곤경에 빠졌다. 그래서 좀 전에 주목했던 더 작은 작업을 수행했다.
- 다른 부분들을 호출자(팩토리 메서드)로 옮김으로써 두 생성자를 일치시켰다.
- times()가 팩토리 메서드를 사용하도록 만들기 위해 리팩토링을 잠시 중단했다.
- 비슷한 리팩토링을 한번의 큰 단계로 처리했다.
- 동일한 생성자들을 상위 클래스로 옮겼다.

```
종종걸음으로 진행하는 것이 답답한가? 그러면 보폭을 조금 넓혀라.
성큼성큼 걷는 것이 불안한가? 그럼 보폭을 줄여라.
지금도, 그리고 앞으로도 정해진 올바른 보폭이라는 것은 존재하지 않는다.
```
