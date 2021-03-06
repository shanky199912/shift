/*
 Copyright 2015 Coursera Inc.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
     http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
limitations under the License.
 */

package org.coursera.android.shift;

import java.util.List;
public class ShiftStringArraySelector extends ShiftValue {

    public ShiftStringArraySelector(String category, String feature, String author,
                                    String[] array, int index, boolean shouldRestartApplicationOnChange) {
        super(category, feature, author, shouldRestartApplicationOnChange);

        StringListSelector defaultValue = new StringListSelector(array,index);
        ShiftManager.getInstance().getValueRegistrationManager().register(this, defaultValue);
    }

    public String getSelectedValue() {
        return ShiftManager.getInstance().getValueRegistrationManager()
                .getStringArraySelectorSelectedValue(this);
    }

    public String[] getStringArray() {
        List<String> list = ShiftManager.getInstance().getValueRegistrationManager()
                .getStringArraySelectorValues(this);
        String[] array = new String[list.size()];
        return list.toArray(array);
    }
}
