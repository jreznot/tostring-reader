/*
 * Copyright © 2022 Yuriy Artamonov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the “Software”), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.strangeway.tsr;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

import static org.strangeway.tsr.TslSyntaxHighlighter.TSL_CLASSNAME;

final class TslColorSettingsPage implements ColorSettingsPage {
  private final AttributesDescriptor[] attributesDescriptors = new AttributesDescriptor[]{
      new AttributesDescriptor("Keyword", TslSyntaxHighlighter.TSL_KEYWORD),
      new AttributesDescriptor("Class name", TSL_CLASSNAME),
      new AttributesDescriptor("String", TslSyntaxHighlighter.TSL_STRING),
      new AttributesDescriptor("Number", TslSyntaxHighlighter.TSL_NUMBER),
      new AttributesDescriptor("Boolean", TslSyntaxHighlighter.TSL_BOOLEAN),
      new AttributesDescriptor("Field name", TslSyntaxHighlighter.TSL_FIELD_NAME),
      new AttributesDescriptor("Constant", TslSyntaxHighlighter.TSL_CONSTANT),
      new AttributesDescriptor("Hashcode", TslSyntaxHighlighter.TSL_HASHCODE),
      new AttributesDescriptor("Braces and Operators//Brackets", TslSyntaxHighlighter.TSL_BRACKETS),
      new AttributesDescriptor("Braces and Operators//Braces", TslSyntaxHighlighter.TSL_BRACES),
      new AttributesDescriptor("Braces and Operators//Parentheses", TslSyntaxHighlighter.TSL_PARENTHESES),
      new AttributesDescriptor("Braces and Operators//Comma", TslSyntaxHighlighter.TSL_COMMA)
  };

  @Override
  public @NotNull Icon getIcon() {
    return TslIcons.FILE_ICON;
  }

  @Override
  public @NotNull SyntaxHighlighter getHighlighter() {
    return new TslSyntaxHighlighter();
  }

  @Override
  public @NonNls @NotNull String getDemoText() {
    return "[\n" +
        "  <className>Order</className>(\n" +
        "    <fieldName>productType</fieldName>=<const>USED</const>,\n" +
        "    <fieldName>name</fieldName>='Some',\n" +
        "    <fieldName>price</fieldName>=10.0,\n" +
        "    <fieldName>required</fieldName>=true,\n" +
        "    <fieldName>ref</fieldName>=null,\n" +
        "    <fieldName>product</fieldName>=<className>Product</className>{\n" +
        "      <fieldName>productType</fieldName>=<const>USED</const>,\n" +
        "      <fieldName>name</fieldName>='Some',\n" +
        "      <fieldName>user</fieldName>=com.example.User@12fea9,\n" +
        "      <fieldName>price</fieldName>=10.0,\n" +
        "      <fieldName>count</fieldName>=100\n" +
        "    }\n" +
        "  )\n" +
        "]";
  }

  @Override
  public @NotNull Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return Map.of(
        "className", TslSyntaxHighlighter.TSL_CLASSNAME,
        "fieldName", TslSyntaxHighlighter.TSL_FIELD_NAME,
        "const", TslSyntaxHighlighter.TSL_CONSTANT
    );
  }

  @Override
  public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
    return attributesDescriptors;
  }

  @Override
  public ColorDescriptor @NotNull [] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @Override
  public @NotNull String getDisplayName() {
    return "ToString";
  }
}
