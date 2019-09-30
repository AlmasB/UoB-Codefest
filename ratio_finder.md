The following problem is derived from a Google interview question shared by Alex Golec. To solve this problem, you may use the Internet only to check Java syntax and API; you may not query the implementation of algorithms or the answer to this problem.

---

### Set up

You are given the following conversion rates:

- 1 kilogram = 1000 grams
- 1 kilogram = 0.157473 stones
- 1 tonne = 2204.62 pounds
- 1 ounce = 28349.5 milligrams
- 1 gram = 1000 milligrams
- 1 metre = 100 centimetres
- 1 metre = 1.09361 yards

---

### Task 1

Write a program that can convert between types above entered by the user. For example, the communication between the user and the program might look like this:

```
> Please enter type 1:
Kg
> Please enter type 2:
g
> Result: 1 Kg is 1000 g
```

Note: you are not allowed to hardcode the answer.

---

### Task 2

Enhance the program to compute a ratio between types are not immediately available above. For example, the ratio between `Kg` and `ounce` is not given above, but can computed. An example communication:

```
> Please enter type 1:
Kg
> Please enter type 2:
oz
> Result: 1 Kg is 35.274 oz
```

---

### Task 3

Allow the program to handle cases where the ratio cannot be computed. For example, the ratio between `Kg` (mass) and `m` (distance) is impossible to compute since they measure different things. Moreover, we cannot compute the ratio for `Kg` and `tonne` because we do not have sufficient data in the conversion rates above.

```
> Please enter type 1:
Kg
> Please enter type 2:
m
> Result: Cannot be computed
```

---

### Task 4

Optimize the program to perform 2 conversions at most to get from any type to any other type. For example, to convert from `Kg` to `oz`, one can convert from `Kg` to `g`, to `mg` and finally to `oz`. That's 3 conversions.

Hint: you might need to do some caching and pre-computations during the program startup.

---

### Task 5 (Optional)

Add a simple user interface to help the user perform conversions.