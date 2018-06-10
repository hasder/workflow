import { SimpledisplayPage } from './app.po';

describe('simpledisplay App', () => {
  let page: SimpledisplayPage;

  beforeEach(() => {
    page = new SimpledisplayPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
