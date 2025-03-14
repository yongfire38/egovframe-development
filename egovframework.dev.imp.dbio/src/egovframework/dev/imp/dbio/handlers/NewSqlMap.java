/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.dev.imp.dbio.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.actions.NewWizardShortcutAction;
import org.eclipse.ui.wizards.IWizardDescriptor;

import egovframework.dev.imp.ide.EgovIdePlugin;

/**
 * NewSqlMap 위저드 실행 객체
 * 
 * @author 개발환경 개발팀 김형조
 * @since 2009.02.20
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.02.20    김형조      최초 생성
 * 
 * 
 * </pre>
 */
@SuppressWarnings("restriction")
public class NewSqlMap extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWizardDescriptor wizardDesc = WorkbenchPlugin.getDefault().getNewWizardRegistry().findWizard("egovframework.dev.imp.dbio.wizard.newSqlMap");

		if (wizardDesc == null) {
			MessageDialog.openInformation(EgovIdePlugin.getActiveWorkbenchWindow().getShell(), "inform", "Selected function has not been installed.");
		} else {
			IAction action = new NewWizardShortcutAction(EgovIdePlugin.getActiveWorkbenchWindow(), wizardDesc);
			action.run();
		}
		return null;
	}

}
