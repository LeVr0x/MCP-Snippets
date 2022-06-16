# HOW TO USE

PS. You need GuiUtils and FontUtil to run this...

### 1. Copy ModButton.java to yours Utils package...

### 2. Go to yours ClickGui code and add button...
```java
  @Override
	public void initGui() {
		this.modButton.add(new ModButton(MOD, X, Y, WIDTH, HEIGHT, "Your String","Your name of image.png"));
    
		super.initGui();
  }
```
### 3. Render button on screen...
Go to your render method and add:
```java
    for(ModButton m : modButton) {
          m.draw();
        }
```
BEFORE super.drawScreen(mouseX, mouseY, partialTicks);

### 4. Make button clickable, bruh...
Add method...
```java
    @Override
      protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        for (ModButton m : modButton) {
          m.onClick(mouseX, mouseY, mouseButton);
        }
      }
```

###5. Congratulations, u have got button :>




