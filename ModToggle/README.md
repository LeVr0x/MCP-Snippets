# HOW TO USE 

### 1. SKID CODE

### 2. CREATE ARRAYLIST IN YOURS MODINSTANCES -_-
```java
  public static ArrayList<Mod> mods = new ArrayList<>();
```

### 3. IN REGISTER METHOD ADD 
```java
  mods.add(yours_mod)
```

### 4. GO TO YOURS MAIN CLASS AND ADD
```java
  public List<Mod> mods;
```

### 5. IN YOURS START METHOD AFTER: 
```java
  ModInstances.register(hudManager);
```

PASTE CODE:
```java
  mods = ModInstances.mods;
		try {
			for (Mod mod : mods) {
				ModToggle.loadEnabled(mod);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
```

### 6. IN YOURS SHUTDOWN METHOD...
```java
  try {
			for (Mod mod : mods) {
				ModToggle.saveEnabled(mod);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
```

### 7. CONGRATULATIONS!!! NOW U ARE PROFFESIONAL SKID!!! -_-
