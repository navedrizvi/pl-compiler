ANTLR := /usr/local/lib/antlr-4.9.3-complete.jar
BUILD_DIR := build
COMPILER_JAR := tigerc.jar
GRAMMAR := Tiger.g4
JAR_DIR := cs8803_bin
MAIN_CLASS_NAME := Tiger

ANTLR_JAVA_FILES := \
	src/TigerBaseListener.java \
	src/TigerBaseVisitor.java \
	src/TigerLexer.java \
	src/TigerListener.java \
	src/TigerParser.java \
	src/TigerVisitor.java

ANTLR_FILES := \
	src/Tiger.interp \
	src/Tiger.tokens \
	src/TigerLexer.interp \
	src/TigerLexer.tokens \
	$(ANTLR_JAVA_FILES)

ANTLR_LIBS := \
	$(BUILD_DIR)/javax \
	$(BUILD_DIR)/org

SOURCES := \
	src/Tiger.java \
	src/TigerGraphListener.java \
	src/TigerSTListener.java \
	src/TigerSemanticAnalysisListener.java \
	src/LexicalErrorListener.java \
	src/ParserErrorListener.java \
	src/SemanticError.java \
	src/SymbolTable.java \
	src/Symbol.java \
	src/SubroutineSymbol.java \
	src/DefinedTypeArraySymbol.java \
	src/DefinedTypeSymbol.java \
	src/VariableSymbol.java

.PHONY:
all: $(COMPILER_JAR)

$(COMPILER_JAR): $(SOURCES) $(ANTLR_JAVA_FILES) $(ANTLR_LIBS)
	@mkdir -p $(BUILD_DIR) $(JAR_DIR)
	@javac -d $(BUILD_DIR) -cp "src:$(ANTLR)" $(SOURCES) \
	$(ANTLR_JAVA_FILES)
	@cd $(BUILD_DIR) && jar cfe ../$(JAR_DIR)/$(COMPILER_JAR) \
	$(MAIN_CLASS_NAME) *.class org javax && cd ..
	@chmod a+rx $(JAR_DIR)/$(COMPILER_JAR)

$(ANTLR_JAVA_FILES): $(GRAMMAR)
	@java -jar $(ANTLR) -o src -visitor $(GRAMMAR)

$(ANTLR_LIBS):
	@mkdir -p $(BUILD_DIR)
	@cd $(BUILD_DIR) && jar xf $(ANTLR) && cd .. @rm -rf $(BUILD_DIR)/META-INF

.PHONY:
clean:
	@rm -f $(JAR_DIR)/$(COMPILER_JAR) $(ANTLR_FILES) \
	$(BUILD_DIR)/*.class
	@rm -rf $(ANTLR_LIBS)
